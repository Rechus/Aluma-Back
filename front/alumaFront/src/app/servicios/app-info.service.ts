import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class AppInfoService {

  private  version = "0.1";

  constructor() { }
  getVersion(){
    return this.version;
  }
}
