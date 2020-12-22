import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class ProductService {
  private baseUrl = 'http://localhost:8080/springboot-crud-rest/api/';

  constructor(private http: HttpClient) { }
  
  login(jsonData): Observable<Object> {
    return this.http.post(`${this.baseUrl}login`, jsonData);
  }

  getProduct(id: number): Observable<any> {
    return this.http.get(`${this.baseUrl}v1/product/${id}`);
  }

  createProduct(product: Object): Observable<Object> {
    return this.http.post(`${this.baseUrl}v1/product`, product);
  }

  updateProduct(id: number, value: any): Observable<Object> {
    return this.http.put(`${this.baseUrl}v1/product/${id}`, value);
  }

  deleteProduct(id: number): Observable<any> {
    return this.http.delete(`${this.baseUrl}v1/product/${id}`, { responseType: 'text' });
  }

  getProductsList(): Observable<any> {
    return this.http.get(`${this.baseUrl}v1/product`);
  }
}