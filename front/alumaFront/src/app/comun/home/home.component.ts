import { AppInfoService } from './../../servicios/app-info.service';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {

  version: string;

  constructor(private appInfo: AppInfoService) {
   }



  ngOnInit(): void {
    this.version = this.appInfo.getVersion();
  }

}
