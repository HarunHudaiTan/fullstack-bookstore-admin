import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Genre } from '../genre';
import { catchError, Observable, tap, throwError } from 'rxjs';
import { environment } from 'environments/environment';
import { response } from 'express';
import { error } from 'console';

@Injectable({
  providedIn: 'root'
})
export class GenreService {

  constructor(private http:HttpClient) { }

  getAllGenres():Observable<Genre[]>{
   return this.http.get<Genre[]>(environment.apiUrl+'/genre')
  }

  getGenreById(id: number): Observable<Genre> {
    return this.http.get<Genre>(`${environment.apiUrl}/genre/${id}`).pipe(
      tap((response) => {
        console.log("Genre load successful");
      }),
      catchError((error) => {
      
        throw error; 
      })
    );
  }


  addGenre(genre:Genre):Observable<Genre>{
    return this.http.post<Genre>(environment.apiUrl+'/genre',genre).pipe(
      tap(response=>{
        console.log("Genre added successfully"+response)
      }),
      catchError((error)=>{
        console.log("Eror adding genre"+error)
         return throwError(() => new Error(error.message || 'Failed to add genre'));
      })
    );
  }

  editGenre(id:number,genre:Genre):Observable<Genre>{
    return this.http.put<Genre>(`${environment.apiUrl}/genre/${id}`,genre).pipe(
      tap((response)=>{
        console.log("Genre edited successfully"+response)
      }),
      catchError((error)=>{
        console.log("Error editing genre")
        return throwError(()=> new Error(error.message||'Failed to edit book'))
      })
    )
  }


  
  




}
