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
  displayedColumns: string[] = ['name', 'translatorName', 'author', 'genre', 'publicationDate', 'pages', 'language', 'publisher', 'actions'];

  constructor(private bookService: BookService, private router: Router) {}

  ngOnInit() {
    this.getAllBooks();
  }

  getAllBooks() {
    this.bookService.getAllBooks().subscribe(
      (data: Book[]) => {
        this.books = data;
        console.log('Books loaded:', this.books);
      },
      error => {
        console.error('Error fetching books:', error);
      }
    );
  }

  navigateToAddBook() {
    this.router.navigate(['/add-book']);
  }

  navigateToEditBook(bookId: number) {
    console.log('Navigating to edit book with ID:', bookId);
    this.router.navigate(['/edit-book', bookId]);
  }

  deleteBook(bookId: number) {
    if (confirm('Are you sure you want to delete this book?')) {
      this.bookService.deleteBook(bookId).subscribe({
        next: () => {
          console.log('Book deleted successfully');
          this.getAllBooks(); // Refresh the book list
        },
        error: (error) => {
          console.error('Error deleting book:', error);
        }
      });
    }
  }
}