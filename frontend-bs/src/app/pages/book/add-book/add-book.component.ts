import { Component, OnInit } from '@angular/core';
import { BookService } from '../service/book.service';
import { Book } from '../book';
import { Genre } from '../../genre/genre';
import { Publisher } from '../publisher';
import { Author } from '../../author/author';
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


  languages: string[] = ['English', 'Turkish', 'French', 'German', 'Spanish'];

  constructor(private bookService: BookService,private router:Router) {}

  ngOnInit() {

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
