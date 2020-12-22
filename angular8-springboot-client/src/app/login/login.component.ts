import { Component, OnInit } from '@angular/core';
import { Product } from '../product';
import { Router } from '@angular/router';
import { ProductService } from '../product.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  userName = "";
  password = "";
  submitted = false;

  constructor(private productService: ProductService,
    private router: Router) { }

  ngOnInit() {
  }

  newLogin(): void {
    this.submitted = false;
    this.userName = "";
	this.password = "";
  }

  save() {
	  let jsonData = {
		  userName: this.userName,
		  password: this.password
	  }
    this.productService.login(jsonData)
      .subscribe(data => {
		  let response: any = data;
		  if(response.login) {
			  this.gotoList();
		  } else {
			  alert("invalid login")
		  }
		}, error => console.log(error));
    
  }

  onSubmit() {
    this.submitted = true;
    this.save();    
  }

  gotoList() {
    this.router.navigate(['/add']);
  }
}
