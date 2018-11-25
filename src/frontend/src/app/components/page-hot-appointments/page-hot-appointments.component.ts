import { Subscription } from 'rxjs';
import {MatTableDataSource} from '@angular/material';
import { Component, OnInit, OnDestroy, AfterViewInit } from '@angular/core';
import { GetStatsService } from './../../services/get-stats.service';

@Component({
  selector: 'app-page-hot-appointments',
  templateUrl: './page-hot-appointments.component.html',
  styleUrls: ['./page-hot-appointments.component.scss']
})
export class PageHotAppointmentsComponent implements OnInit, OnDestroy, AfterViewInit {

  appointmentsSub: Subscription;
  dataSource;

  constructor(private getStatsService: GetStatsService) { }

  createDataArray(rawdata) {
    const appointments = [];
    rawdata['data'].forEach((element, index) => {
      const obj = {};
      obj['position'] = index + 1;
      obj['place'] = element.attributes.place;
      obj['locality'] = element.attributes.locality;
      obj['address'] = element.attributes.address;
      obj['phone'] = element.attributes.phone;
      obj['date'] = element.attributes['dates']['date'];
      appointments.push(obj);
    });
    this.dataSource = appointments;
  }

  ngOnInit() {
    this.appointmentsSub = this.getStatsService.getHotAppointments()
    .subscribe((res) => {
      this.createDataArray(res);
    });
  }

  ngAfterViewInit() {

    // this.appointmentsSub = this.getStatsService.getHotAppointments()
    // .subscribe((res) => {
    //   this.createDataArray(res);
    // });
  }

  ngOnDestroy() {
    this.appointmentsSub.unsubscribe();
  }

}
