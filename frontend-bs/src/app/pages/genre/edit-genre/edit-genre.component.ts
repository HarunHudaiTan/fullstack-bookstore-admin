import { Component, OnInit } from '@angular/core';
import { GenreService } from '../service/genre.service';
import { Genre } from '../genre';
import { error } from 'console';
import { ActivatedRoute, Route, Router, RouterLink } from '@angular/router';
import { FormsModule } from '@angular/forms';
import { CommonModule } from '@angular/common';

@Component({
  selector: 'app-edit-genre',
  standalone: true,
  imports: [FormsModule,CommonModule,RouterLink],
  templateUrl: './edit-genre.component.html',
  styleUrl: './edit-genre.component.scss'
})
export class EditGenreComponent implements OnInit{
 
  genre:Genre={
    id:null,
    name:'',
    description:''
  }

  constructor(private genreService:GenreService,
    private route:ActivatedRoute,
  private router:Router){

  }
  ngOnInit(): void {
    this.route.paramMap.subscribe(params=>{
      const id=+params.get('id')
      if(id){
        console.log("loading author with id")
        this.loadGenres(id)
      }
      else{
        console.error("error loading genre")
      }
    });

  }

  editGenre(id:number,genre:Genre){
    this.genreService.editGenre(id,genre).subscribe({
      next:(response)=>{
        this.genre=response;
        this.router.navigate(['/genre'])
        console.log("Genre updated successfully"+genre)
      },
     error:(error)=>{
      console.log("Error updating genres",error)
     }
    });
  }

loadGenres(id:number){
  this.genreService.getGenreById(id).subscribe({
     next:(response)=>{
      this.genre=response
     },
     error:(error)=>{
      console.log("error loading genres"+error)
     }
  })
}
}
