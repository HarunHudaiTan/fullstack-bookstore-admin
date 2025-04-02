import { Component } from '@angular/core';
import { AuthorService } from '../service/author.service';
import { Author } from '../author';
import { Router } from '@angular/router';
import { FormsModule, NgForm } from '@angular/forms';
import { CommonModule } from '@angular/common';
import { RouterLink } from '@angular/router';

@Component({
  selector: 'app-add-author',
  standalone: true,
  imports: [FormsModule, CommonModule, RouterLink],
  templateUrl: './add-author.component.html',
  styleUrl: './add-author.component.scss'
})
export class AddAuthorComponent {
  author: Author = {
    id: null,
    firstName: '',
    lastName: ''
  };
  
  constructor(private authorService: AuthorService, private router: Router) {
  }
  
  addAuthor() {
    this.authorService.addAuthor(this.author).subscribe({
      next: (response) => {
        console.log("Author added successfully");
        this.router.navigate(['author']);
      },
      error: (error) => {
        console.log("Error adding author", error);
      }
    });
  }
}