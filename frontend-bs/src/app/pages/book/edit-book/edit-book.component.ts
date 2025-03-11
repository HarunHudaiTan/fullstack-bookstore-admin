import { Component, OnInit } from '@angular/core';
import { BookService } from '../service/book.service';
import { Book } from '../book';
import { Genre } from '../genre';
import { Author } from '../../author/author';
import { Publisher } from '../publisher';
import { ActivatedRoute, Router } from '@angular/router';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { RouterLink } from '@angular/router';

@Component({
  selector: 'app-edit-book',
  standalone: true,
  imports: [
    CommonModule,
    FormsModule,
    RouterLink
  ],
  templateUrl: './edit-book.component.html',
  styleUrl: './edit-book.component.scss'
})
export class EditBookComponent implements OnInit {
  // Properties for dropdown lists
  genres: Genre[] = [];
  authors: Author[] = [];
  publishers: Publisher[] = [];
  
  book: Book = {
    id: 0,
    name: '',
    translatorName: '',
    genre: {} as Genre,
    publicationDate: '',
    pages: '',
    language: '',
    stockQuantity: 0,
    price: 0,
    publisher: {} as Publisher,
    author: {} as Author
  };

  constructor(
    private bookService: BookService,
    private router: Router,
    private route: ActivatedRoute) {

    }

  ngOnInit(): void {

    this.loadGenres();
    this.loadAuthors();
    this.loadPublishers();
    

    this.route.paramMap.subscribe(params => {
      const id = +params.get('id'); // Using paramMap instead of params
      if (id) {
        console.log('Loading book with ID:', id);
        this.loadBookDetails(id);
      } else {
        console.error('No book ID provided in the route');
      }
    });
  }

  loadBookDetails(id: number): void {
    this.bookService.getBookById(id).subscribe({
      next: (res: Book) => {
        console.log('Book details loaded:', res);
        this.book = res;
      },
      error: (error) => {
        console.error('Error loading book:', error);
      }
    });
  }

  loadGenres(): void {
    this.bookService.getAllGenres().subscribe({
      next: (genres: Genre[]) => {
        this.genres = genres;
      },
      error: (error) => {
        console.error('Error loading genres:', error);
      }
    });
  }

  loadAuthors(): void {
    this.bookService.getAllAuthors().subscribe({
      next: (authors: Author[]) => {
        this.authors = authors;
      },
      error: (error) => {
        console.error('Error loading authors:', error);
      }
    });
  }

  loadPublishers(): void {
    this.bookService.getAllPublishers().subscribe({
      next: (publishers: Publisher[]) => {
        this.publishers = publishers;
      },
      error: (error) => {
        console.error('Error loading publishers:', error);
      }
    });
  }

  editBook(): void {
    console.log('Submitting edit for book ID:', this.book.id);
    this.bookService.editBooks(this.book.id, this.book).subscribe({
      next: (response) => {
        console.log('Book updated successfully:', response);
        this.router.navigate(['/book']);
      },
      error: (error) => {
        console.error('Error updating book:', error);
      }
    });
  }

  // Optional: Add a cancel method to return to the book list

}