import { Subscription } from 'rxjs';
import { Component, OnDestroy } from '@angular/core';
import { specialisations, locations } from './../../services/data.model';
import { GetStatsService } from './../../services/get-stats.service';

@Component({
  selector: 'app-page-registration',
  templateUrl: './page-registration.component.html',
  styleUrls: ['./page-registration.component.scss']
})
export class PageRegistrationComponent implements OnDestroy {

  specs = specialisations;
  locals = locations;
  placesSub: Subscription;
  mapPlaces;
  lat: number;
  lng: number;
  bookAppointmentText = 'Book this appointment!';

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
      obj['nip'] = element.attributes['nip-provider'];
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

  bookAppointment(appointment) {
    console.log('book!', appointment);
    this.bookAppointmentText = 'Booked! Check your e-mail';
  }

  ngOnDestroy() {
    if (this.placesSub) {
      this.placesSub.unsubscribe();
    }
  }

}
