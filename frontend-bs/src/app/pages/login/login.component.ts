import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { AuthenticationService } from './service/authentication/authentication.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.scss']
})
export class LoginComponent  {
  username: string ;
  password: number ;

  constructor(private router: Router,private authService: AuthenticationService) { }


  login(username:string,password:number){
    this.authService.logIn(username,password).subscribe({
      next:(response)=>{
        console.log("user logged in succesfully")
        this.router.navigate(['/dashboard']);
      },
      error:(error)=>{
        console.log(error);
      }
    })
  }

  onLogin() {
    console.log('Login attempt:', this.username);
    this.router.navigate(['/dashboard']);
  }
  
  signupPageRoute(){
    this.router.navigate(['/signup'])
  }
}
