import { Component, OnInit } from '@angular/core';
import { ArticleService } from '../apis/article.service';


@Component({
  selector: 'app-articles',
  templateUrl: './articles.page.html',
  styleUrls: ['./articles.page.scss'],
})
export class ArticlesPage implements OnInit {

  constructor(private service:ArticleService) { }

  ngOnInit() {
    this.service.getAllArticles().subscribe(response => {
      console.log(response);
    });
    
  }

}
