import { Component } from '@angular/core';
import { AuthorService } from '../service/author.service';
import { Author } from '../author';
import { error } from 'console';
import { OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';
@Component({
  selector: 'app-edit-author',
  standalone: true,
  imports: [CommonModule,FormsModule],
  templateUrl: './edit-author.component.html',
  styleUrl: './edit-author.component.scss'
})
export class EditAuthorComponent implements OnInit {

  author: Author = {
    id: null,
    firstName: '',
    lastName: ''
  }

  constructor(private authorService: AuthorService, private route: ActivatedRoute,private router:Router) {

  }
  ngOnInit(): void {
    this.route.paramMap.subscribe(params => {
      const id = +params.get('id')
      if (id) {
        console.log("Loading author with id")
        this.loadAuthor(id)
      }
      else {
        console.error("error loading author with id")
      }
    });
  }

  loadAuthor(id: number) {
    this.authorService.getAuthorById(id).subscribe({
      next: (response) => {
        this.author = response
        console.log("author loaded successfully" + response)
      },
      error: (error) => {
        console.log("author load failed" + error)
      }
    })
  }
  
  editAuthor(){
   this.authorService.editAuthor(this.author.id,this.author).subscribe({
    next:(response)=>{
      console.log("author editted successfully"+response)
      this.router.navigate(['/author'])
    },
    error:(error)=>{
     console.log("edit author failed"+error)
    }
   })
  }



}
