import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable, catchError, finalize, tap, throwError } from 'rxjs';
import { Book } from '../book';
import { environment } from 'environments/environment';
import { BehaviorSubject } from 'rxjs';
import { Genre } from '../genre';
import { Author } from '../author';
import { Publisher } from '../publisher';

@Injectable({
  providedIn: 'root'
})
export class BookService {

  private isLoading = new BehaviorSubject<boolean>(false);
  isLoading$ = this.isLoading.asObservable();

  constructor(private http:HttpClient) {
    
   }

   getAllBooks():Observable<Book[]>{
    return this.http.get<Book[]>(environment.apiUrl + '/book');
   }
   addBook(book:Book):Observable<Book>{
    this.isLoading.next(true);
    return this.http.post<Book>(`${environment.apiUrl}/book`, book).pipe(
      tap((response) => {
        console.log('Book added successfully:', response);
      }),
      catchError((error) => {
        console.error('Error adding book:', error);
        return throwError(() => new Error(error.message || 'Failed to add book'));
      }),
      finalize(() => {
        this.isLoading.next(false);
      })
    );
   }
   getAllGenres():Observable<Genre[]>{
    return this.http.get<Genre[]>(environment.apiUrl + '/genre');
   }
   getAllPublishers():Observable<Publisher[]>{
    return this.http.get<Publisher[]>(environment.apiUrl + '/publisher');
   }
   getAllAuthors():Observable<Author[]>{
    return this.http.get<Author[]>(environment.apiUrl + '/author');
   }
  
}
