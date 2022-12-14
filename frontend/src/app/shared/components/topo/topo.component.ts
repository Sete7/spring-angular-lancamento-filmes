import { Component, OnInit, ViewChild } from '@angular/core';
import { MatSidenav } from '@angular/material/sidenav';

@Component({
  selector: 'app-topo',
  templateUrl: './topo.component.html',
  styleUrls: ['./topo.component.css']
})
export class TopoComponent implements OnInit {

  @ViewChild('sidenav', {static: false}) sidenav: MatSidenav;

  reason = '';

  close(reason: string): void {
    this.reason = reason;
    this.sidenav.close();
  }

  constructor() { }

  ngOnInit(): void {
  }

  closeSideNav(): void {
    this.sidenav.close();
  }

  openSideNav(): void {
    this.sidenav.open();
  }

}
