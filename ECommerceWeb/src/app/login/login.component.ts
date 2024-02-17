import { Component } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { MatSnackBar } from '@angular/material/snack-bar';
import { AuthService } from '../services/auth/auth.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.scss']
})
export class LoginComponent {

  loginForm!: FormGroup;
  hidePassword= true;

  constructor(private fb: FormBuilder,
    private snackBar: MatSnackBar,
    private authService: AuthService,
    private router: Router){
    }

  ngOnInit(): void{
    this.loginForm= this.fb.group({
      email: [null, [Validators.required, Validators.email]],
      password: [null, [Validators.required]]
    })
  }

  togglePasswordVisibility(){
    this.hidePassword= !this.hidePassword;
  }

  onSubmit(): void{
    const username=this.loginForm.get('email')?.value;
    const password=this.loginForm.get('password')?.value;
    console.log("user", username);
    this.authService.login(username, password).subscribe(
      (res)=>{
        this.snackBar.open("LOGIN SUCCESS", "OK", {duration: 5000})
      },
      (error)=>{
        this.snackBar.open("Bad Credentials", "ERROR", {duration: 5000});
      }
    )
  }

}
