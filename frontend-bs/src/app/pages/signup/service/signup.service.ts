import { Inject, Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { User } from 'app/pages/user/User';
import { environment } from 'environments/environment';

@Injectable({
  providedIn: 'root'
})
export class SignupService {

  constructor(private http:HttpClient) {
    
   }
  
   signUp(name: string, surname: string, username: string, password: number): Observable<User> {
    const url = `${environment.apiUrl}/auth/addNewUser`;

    return this.http.post<User>(url,{
      name,
      surname,
      username,
      password,
      authorities : (["ROLE_ADMIN"])
    })
   }
  
}
