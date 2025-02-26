import { Component, OnInit } from '@angular/core';
import { BookService } from '../service/book.service';
import { Book } from '../book';
import { Genre } from '../genre';
import { Author } from '../author';
import { Publisher } from '../publisher';
import { ActivatedRoute } from '@angular/router';
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
export class EditBookComponent implements OnInit{
  constructor(private bookService:BookService,private route:ActivatedRoute){

  }
  book: Book = {
    id:Number(this.route.snapshot.paramMap.get('id')),
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
 
  ngOnInit(): void {
  this.bookService.getBookById(this.book.id).subscribe({
    next:(res:Book)=>{
      this.book.name=res.name;
      this.book.translatorName=res.translatorName;
      this.book.genre=res.genre;
      this.book.publicationDate=res.publicationDate;
      this.book.pages=res.pages;
      this.book.language=res.language;
      this.book.stockQuantity=res.stockQuantity;
      this.book.price=res.price;
      this.book.publisher=res.publisher;
      this.book.author=res.author;
    },
    error: (error) => {
      console.error('Error loading book:', error);

    }
  
  });
  }
  editBook(): void {
    this.bookService.editBooks(this.book.id, this.book).subscribe({
      next: (response) => {
        console.log('Book updated successfully:', response);
      },
      error: (error) => {
        console.error('Error updating book:', error);
      }
    });
  }

}
