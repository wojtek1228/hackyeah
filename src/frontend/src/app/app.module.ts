import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { HttpClientModule } from '@angular/common/http';

import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { MatToolbarModule, MatButtonModule, MatInputModule,
  MatFormFieldModule, MatSelectModule, MatTableModule, MatPaginatorModule, MatSortModule } from '@angular/material';
import { AgmCoreModule } from '@agm/core';
import { AgmJsMarkerClustererModule } from '@agm/js-marker-clusterer';

import { AppRoutingModule } from './app-routing.module';

import { AppComponent } from './app.component';
import { NavbarComponent } from './components/navbar/navbar.component';
import { PageStatisticsComponent } from './components/page-statistics/page-statistics.component';
import { PageAboutComponent } from './components/page-about/page-about.component';

import { GetStatsService } from './services/get-stats.service';
import { PageRegistrationComponent } from './components/page-registration/page-registration.component';
import { PageHotAppointmentsComponent } from './components/page-hot-appointments/page-hot-appointments.component';

@NgModule({
  declarations: [
    AppComponent,
    NavbarComponent,
    PageStatisticsComponent,
    PageAboutComponent,
    PageRegistrationComponent,
    PageHotAppointmentsComponent
  ],
  imports: [
    HttpClientModule,
    BrowserModule,
    BrowserAnimationsModule,
    MatToolbarModule,
    MatButtonModule,
    AppRoutingModule,
    MatInputModule,
    MatFormFieldModule,
    MatSelectModule,
    MatTableModule,
    AgmCoreModule.forRoot({
      apiKey: 'AIzaSyDPZGi07HxfgMFLUZqQEVIkfl8SIvkRKEI'
    }),
    AgmJsMarkerClustererModule,
    MatPaginatorModule,
    MatSortModule
  ],
  providers: [GetStatsService],
  bootstrap: [AppComponent]
})
export class AppModule { }
