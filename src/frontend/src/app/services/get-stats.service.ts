import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class GetStatsService {

  constructor(private http: HttpClient) {}

  getStats(specialisation: string): any {
    return this.http.get(`http://localhost:8080/appointmentStatistics/${specialisation.toUpperCase()}`);
  }

  downloadFile(specialisation: string): any {
    console.log('downloading');
    return this.http.get(`http://localhost:8080/download/${specialisation.toUpperCase()}`);
  }

  getHotAppointments(specialisation?: string): any {
    return this.http.get('http://localhost:8080/hotAppointment/KARDIOLOG');
  }

  getAppointments(specialisation: string, city: string, province: string): any {
    return this.http.get(`http://localhost:8080/nfzAppointments/${specialisation}?city=${city}&province=${province}`);
  }
}

