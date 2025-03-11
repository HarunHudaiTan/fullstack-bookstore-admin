import { Component } from '@angular/core';
import { OnInit } from '@angular/core';
import { AuthorService } from './service/author.service';
import { Author } from './author';
import { response } from 'express';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';
@Component({
  selector: 'app-author',
  standalone: true,
  imports: [CommonModule, FormsModule],
  templateUrl: './author.component.html',
  styleUrl: './author.component.scss'
})
export class AuthorComponent implements OnInit {

  authors:Author[]=[];
  searchText: string = '';
constructor(private authorServie:AuthorService){


}
  ngOnInit(): void {
  this.loadAuthors();
  }

  loadAuthors(){
    this.authorServie.getAllAuthors().subscribe(
      (response:Author[])=>{
       this.authors=response
       console.log("Author loaded succesfully")
      },
      error=>{
        console.log("Error loading books: " + error.message)
      }
    );
  }


  

  

}
