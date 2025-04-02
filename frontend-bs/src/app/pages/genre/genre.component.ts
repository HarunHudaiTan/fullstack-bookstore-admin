import { Component, OnInit } from '@angular/core';
import { GenreService } from './service/genre.service';
import { Genre } from './genre';
import { FormsModule } from '@angular/forms';
import { CommonModule } from '@angular/common';
import { Router } from '@angular/router';

@Component({
  selector: 'app-genre',
  standalone: true,
  imports: [FormsModule,CommonModule],
  templateUrl: './genre.component.html',
  styleUrl: './genre.component.scss'
})
export class GenreComponent implements OnInit{

   genres:Genre[]
   searchText:''
  constructor(private genreService:GenreService,private router:Router){}


  ngOnInit(): void {
   this.loadGenres()
  }

  navigateToAddGenre(){
    this.router.navigate(['/add-genre'])
  }
  navigateToEditGenre(id:number){
    this.router.navigate(['/edit-genre',id])

  }
  
  loadGenres(){
  this.genreService.getAllGenres().subscribe({
   next: (response:Genre[])=>{
    console.log('Genres loaded')
    this.genres=response
    },
   error: (error)=>{
      console.log('Error loading genres'+error)
    }
  })
  }
  
}
