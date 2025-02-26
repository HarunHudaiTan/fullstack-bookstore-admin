import { Component, OnInit } from '@angular/core';
import { BookService } from '../service/book.service';
import { Book } from '../book';
import { Genre } from '../genre';
import { Publisher } from '../publisher';
import { Author } from '../author';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { MatSelectModule } from '@angular/material/select';
import { MatInputModule } from '@angular/material/input';
import { MatFormFieldModule } from '@angular/material/form-field';
import { MatButtonModule } from '@angular/material/button';
import { MatDatepickerModule } from '@angular/material/datepicker';
import { MatNativeDateModule } from '@angular/material/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-add-book',
  standalone: true,
  imports: [
    CommonModule,
    FormsModule,
    MatSelectModule,
    MatInputModule,
    MatFormFieldModule,
    MatButtonModule,
    MatDatepickerModule,
    MatNativeDateModule
  ],
  templateUrl: './add-book.component.html',
  styleUrls: ['./add-book.component.scss']
})
export class AddBookComponent implements OnInit {
  book: Book = {
    id:null,
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

  genres: Genre[] = [];
  publishers: Publisher[] = [];
  authors: Author[] = [];
  languages: string[] = ['English', 'Turkish', 'French', 'German', 'Spanish'];

  constructor(private bookService: BookService,private router:Router) {}

  ngOnInit() {
    this.loadGenres();
    this.loadPublishers();
    this.loadAuthors();
  }

  loadGenres() {
    this.bookService.getAllGenres().subscribe({
      next: (data) => {
        this.genres = data;
        console.log('Genres loaded:', this.genres);
      },
      error: (error) => {
        console.error('Error loading genres:', error);
      }
    });
  }

  loadPublishers() {
    this.bookService.getAllPublishers().subscribe({
      next: (data) => {
        this.publishers = data;
        console.log('Publishers loaded:', this.publishers);
      },
      error: (error) => {
        console.error('Error loading publishers:', error);
      }
    });
  }

  loadAuthors() {
    this.bookService.getAllAuthors().subscribe({
      next: (data) => {
        this.authors = data;
        console.log('Authors loaded:', this.authors);
      },
      error: (error) => {
        console.error('Error loading authors:', error);
      }
    });
  }

  addBook() {
    this.bookService.addBook(this.book).subscribe({
      next: (response) => {
        console.log('Book added successfully', response);
        this.resetForm();
       this.router.navigate(['/book'])
      },
      error: (error) => {
        console.error('Error adding book:', error);
      }
    });
  }

  private resetForm() {
    this.book = {
      id:null,
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
  }
}
