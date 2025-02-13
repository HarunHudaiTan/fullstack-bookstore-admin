import { Component, OnInit } from '@angular/core';

import { SignupService } from './service/signup.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-signup',
  templateUrl: './signup.component.html',
  styleUrls: ['./signup.component.scss']
})
export class SignupComponent implements OnInit {
  name:string;
  surname:string;
  username:string;
  password:number;
  isSuccessful = false;
  isSignUpFailed = false;
  errorMessage = '';
  constructor(
    private signupService: SignupService,
    private router: Router
  ) { }

  ngOnInit(): void {

  }
 
  signUp(name:string,surname:string,username:string,password:number){
    this.signupService.signUp(name,surname,username,password).subscribe({
      next: (response) => {
        console.log('Signed up successfully!', response);
        this.isSuccessful = true;
        this.isSignUpFailed = false;
        // Navigate to login page after successful signup
        this.router.navigate(['/login']);
      },
      error: (error) => {
        console.error('Error signing up', error);
        this.errorMessage = error.error.message;
        this.isSignUpFailed = true;
      }
    });
  }
    
  
}
