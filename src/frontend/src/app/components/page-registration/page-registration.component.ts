import { Subscription } from 'rxjs';
import { Component, OnInit } from '@angular/core';
import { specialisations, locations } from './../../services/data.model';
import { GetStatsService } from './../../services/get-stats.service';

@Component({
  selector: 'app-page-registration',
  templateUrl: './page-registration.component.html',
  styleUrls: ['./page-registration.component.scss']
})
export class PageRegistrationComponent implements OnInit {

  specs = specialisations;
  locals = locations;
  placesSub: Subscription;
  mapPlaces;
  lat: number;
  lng: number;

  constructor(private getStatsService: GetStatsService) { }

  showAppointments(spec: string, city: string) {
    if (!spec || !city) {
      return;
    }

    const local = this.locals.filter(obj => {
      return obj.city === city;
    });

    this.placesSub = this.getStatsService.getAppointments(spec, city, local[0]['province'])
    .subscribe((res) => {
      this.displayMap(res);
    });
  }

  createDataArray(rawdata) {
    const appointments = [];
    rawdata['data'].forEach((element) => {
      const obj = {};
      obj['place'] = element.attributes.place;
      obj['city'] = element.attributes.locality;
      obj['address'] = element.attributes.address;
      obj['phone'] = element.attributes.phone;
      obj['date'] = element.attributes['dates']['date'];
      obj['long'] = element.attributes.longitude;
      obj['lat'] = element.attributes.latitude;
      appointments.push(obj);
    });
    this.mapPlaces = appointments;
    console.log(this.mapPlaces);
  }

  displayMap(places) {
    this.createDataArray(places);
    this.lat = Number(this.mapPlaces[0].lat);
    this.lng = Number(this.mapPlaces[0].long);
  }

  ngOnInit() {
  }

}
