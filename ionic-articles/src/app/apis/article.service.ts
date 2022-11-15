import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})

export class ArticleService {

  private base_url:string = "http://localhost/mobile/";

  constructor(private http: HttpClient) { }

  getAllArticles(){
    const response = this.http.get( this.base_url + "get_articles.php");
    return response;
  }

  addArticle(name: string, author:string){
    const response = this.http.post( this.base_url + "add_article.php",{
      "name": name,
      "author": author 
    });
    return response;
  }
}
