import { Injectable } from '@angular/core';
import { BehaviorSubject, map } from 'rxjs';
import { User } from '../../User';
import { HttpClient } from '@angular/common/http';
import { environment } from 'environments/environment';

@Injectable({
  providedIn: 'root'
})
export class AuthenticationService {

  public userSubject: BehaviorSubject<User>;

  constructor(private http: HttpClient) {
    this.userSubject = new BehaviorSubject<User>(null);
  }

  public get userValue(): User {
    return this.userSubject.value;
  }

  logIn(username: String, password: number) {
    const url: string = `${environment.apiUrl}/auth/login`;
    const body: any = { 
      username: username, password: password };
    return this.http.post<any>(url, body).pipe(map(res => {
      const user: User = {
        name: res.name,
        surname: res.surname,
        username: res.username,
        password: res.password,
        authorities: res.authorities,
        accessToken: res.accessToken,
        refreshToken: res.refreshToken
      };
      this.userSubject.next(user);
      localStorage.setItem('user', JSON.stringify(user));
      return user;
    }));
  }
  refreshToken(){
    const url:string= `${environment.apiUrl}/auth/refresh`;
    const body: any={refreshToken:this.userValue.refreshToken};
    this.http.post<any>(url, body).pipe(map(token=>{
      const user: User = {
        name: this.userValue.name,
        surname: this.userValue.surname,
        username: this.userValue.username,
        password: this.userValue.password,
        authorities: this.userValue.authorities,
        accessToken: token.accessToken,
        refreshToken: token.refreshToken
      };
      this.userSubject.next(user);
      localStorage.setItem('user', JSON.stringify(user));
      return user;
    }))
  }

}
