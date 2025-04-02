import { Component } from '@angular/core';
import { GenreService } from '../service/genre.service';
import { Router } from '@angular/router';
import { Genre } from '../genre';
import { FormsModule } from '@angular/forms';
import { CommonModule } from '@angular/common';

@Component({
  selector: 'app-add-genre',
  standalone: true,
  imports: [FormsModule,CommonModule],
  templateUrl: './add-genre.component.html',
  styleUrl: './add-genre.component.scss'
})
export class AddGenreComponent {

  genre:Genre={
    id:null,
    name:'',
    description:''
  }

  constructor(private genreService: GenreService,private router:Router) { }

  
  addGenre(){
    this.genreService.addGenre(this.genre).subscribe({
     next: (response)=>{
        console.log('Genre added successfully '+ response)
        this.router.navigate(['/genre'])
      },
     error: (error)=>{
        console.error('Error adding genre'+error)
      }
  });
  }

}
