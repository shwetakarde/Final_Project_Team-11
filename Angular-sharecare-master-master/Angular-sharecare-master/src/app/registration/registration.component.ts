import { Component, OnInit } from '@angular/core';
import { User } from '../user'
import { NgForm } from '@angular/forms';
import { Router } from '@angular/router';
import { RegistrationService } from '../registration.service';
import { Route } from '@angular/compiler/src/core';

@Component({
  selector: 'app-registration',
  templateUrl: './registration.component.html',
  styleUrls: ['./registration.component.css']
})
export class RegistrationComponent implements OnInit {

  msg = ''
  user = new User();
  constructor(private _service: RegistrationService, private _router: Router) {

  }

  ngOnInit(): void {
  }


  registerNow() {
    this._service.registerUserFromRemote(this.user).subscribe(
      data => {
        console.log("response received");
        this._router.navigate(['/login'])

      },
      error => {
        console.log("exception occured");
        this.msg = "Email already Exists";
      }

    )
  }
}
