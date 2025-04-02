import { Component } from '@angular/core';
import { OnInit } from '@angular/core';
import { AuthorService } from './service/author.service';
import { Author } from './author';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { Router } from '@angular/router';
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
constructor(private authorServie:AuthorService,private router:Router){


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

  navigateToAddAuthor(){
    this.router.navigate(['/add-author'])
  }
  navigateToEditAuthor(id:number){
    this.router.navigate(['/edit-author',id])
  }


  

  

}
