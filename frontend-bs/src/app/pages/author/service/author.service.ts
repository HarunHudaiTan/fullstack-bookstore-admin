import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { catchError, Observable, tap, throwError } from 'rxjs';
import { Author } from '../author';
import { environment } from '../../../../environments/environment';
@Injectable({
  providedIn: 'root'
})
export class AuthorService {
   

  constructor(private http:HttpClient) { }

  getAllAuthors():Observable<Author[]>{
    return this.http.get<Author[]>(environment.apiUrl+"/author");
  }
  addAuthor(author:Author):Observable<Author>{
    return this.http.post<Author>(environment.apiUrl+"/author",author).pipe(
      tap((response=>{
        console.log("Auther added succesfully"+ response)
      })),
      catchError(error=>{
            console.error('Error adding book:', error);
            return throwError(() => new Error(error.message || 'Failed to add author'));
      })
      
    );
  }

  editAuthor(id:number,author:Author):Observable<Author>{
    return this.http.put<Author>(`${environment.apiUrl}/author/${id}`,author).pipe(
      tap(response=>{
        console.log("Author updated succesfully"+response)
      }),
      catchError((error) => {
        console.error('Error editing book:', error);
        return throwError(() => new Error(error.message || 'Failed to edit author'));
      })
    )

  }
  
}
