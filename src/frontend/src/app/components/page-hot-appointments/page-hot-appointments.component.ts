import { Subscription } from 'rxjs';
import { Component, OnInit, OnDestroy } from '@angular/core';
import { GetStatsService } from './../../services/get-stats.service';

@Component({
  selector: 'app-page-hot-appointments',
  templateUrl: './page-hot-appointments.component.html',
  styleUrls: ['./page-hot-appointments.component.scss']
})
export class PageHotAppointmentsComponent implements OnInit, OnDestroy {

  appointmentsSub: Subscription;
  dataSource;

  constructor(private getStatsService: GetStatsService) { }

  ngOnInit() {
    this.appointmentsSub = this.getStatsService.getHotAppointments()
    .subscribe((res) => {
      // this.createDataArray(res);
      this.dataSource = res;
    });
  }

  ngOnDestroy() {
    this.appointmentsSub.unsubscribe();
  }

}
