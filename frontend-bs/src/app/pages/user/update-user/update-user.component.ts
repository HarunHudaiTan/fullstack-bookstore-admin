import { Component } from '@angular/core';
import { UserService } from '../service/user.service';
import { User } from '../User';
import { ActivatedRoute } from '@angular/router';
import { MatCardModule } from '@angular/material/card';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { MatButtonModule } from '@angular/material/button';
import { MatFormFieldModule } from '@angular/material/form-field';
import { MatInputModule } from '@angular/material/input';
import { MatProgressBarModule } from '@angular/material/progress-bar';
@Component({
  selector: 'app-update-user',
  standalone: true,
  templateUrl: './update-user.component.html',
  styleUrl: './update-user.component.scss',
  imports: [MatCardModule,
    CommonModule,
    MatButtonModule,
    MatInputModule,
    MatProgressBarModule,
    MatCardModule, 
    FormsModule 
  ],
})
export class UpdateUserComponent {
   userId:number
   user:User
  constructor(private userService: UserService,private route:ActivatedRoute) {
   }

   ngOnInit(): void {
    this.userId=Number(this.route.snapshot.paramMap.get('id'));
    this.userService.getUserById(this.userId).subscribe({
      next: (user) => {
        this.user = user;
      },
      error: (error) => {
        console.error('Error fetching user:', error);
      }
    });
   }
   updateUser(){
    this.userService.updateUser(this.userId,this.user).subscribe({
      next: (response) => {
        console.log('User updated successfully:', response);
      },
      error: (error) => {
        console.error('Error updating user:', error);
      }
    });
   }

}
