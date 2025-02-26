import { Component, OnInit } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { Book } from './book';
import { BookService } from './service/book.service';
import { DatePipe } from '@angular/common';
import { Router } from '@angular/router';
import { BookSearchPipe } from './pipes/book-search.pipe';

@Component({
  selector: 'app-book',
  standalone: true,
  imports: [
    CommonModule,
    FormsModule,
    DatePipe,
    BookSearchPipe
  ],
  templateUrl: './book.component.html',
  styleUrls: ['./book.component.scss']
})
export class BookComponent implements OnInit {
  books: Book[] = [];
  searchText: string = '';
  displayedColumns: string[] = ['name', 'translatorName', 'author', 'genre', 'genreDescription', 'publicationDate', 'pages', 'language', 'publisher'];
  
  constructor(private bookService: BookService, private router: Router) {}

  ngOnInit() {
    this.getAllBooks();
  }

  getAllBooks() {
    this.bookService.getAllBooks().subscribe(
      (data: Book[]) => {
        this.books = data;
      },
      error => {
        console.error('Error fetching books:', error);
      }
    );
  }


  navigateToAddBook() {
    this.router.navigate(['/add-book']);
  }

  navigateToEditBook() {
    this.router.navigate(['/edit-book']);
  }
}
