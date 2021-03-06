import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';

import { PageStatisticsComponent } from './components/page-statistics/page-statistics.component';
import { PageRegistrationComponent } from './components/page-registration/page-registration.component';
import { PageHotAppointmentsComponent } from './components/page-hot-appointments/page-hot-appointments.component';

const routes: Routes = [
  {
    path: '',
    component: PageRegistrationComponent
  },
  {
    path: 'hot-appointments',
    component: PageHotAppointmentsComponent
  },
  {
    path: 'statistics',
    component: PageStatisticsComponent
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule],
  declarations: []
})
export class AppRoutingModule { }
