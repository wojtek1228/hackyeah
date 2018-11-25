import { Component, OnDestroy} from '@angular/core';
import { specialisations } from './../../services/data.model';
import { GetStatsService } from './../../services/get-stats.service';
import { Subscription } from 'rxjs';

@Component({
  selector: 'app-page-statistics',
  templateUrl: './page-statistics.component.html',
  styleUrls: ['./page-statistics.component.scss']
})
export class PageStatisticsComponent implements OnDestroy {

  private specs = specialisations;
  statPlaces;
  lat: number;
  lng: number;
  private statsSub: Subscription;
  private fileSub: Subscription;
  fileLink: string;

  constructor(private getStatsService: GetStatsService) { }

  showStats(value: string) {
    this.createFileDownloadLink(value);
    this.statsSub = this.getStatsService.getStats(value)
      .subscribe((res) => this.displayMap(res));
  }

  createFileDownloadLink(value: string) {
    this.fileLink = `http://127.0.0.1:8080/download/${value.toUpperCase()}`;
  }

  displayMap(places) {
    this.statPlaces = places;
    this.lat = Number(places[0].lattitude);
    this.lng = Number(places[0].longitude);
  }

  exportData(data: string) {
    console.log('subscribing');
    this.fileSub = this.getStatsService.downloadFile(data)
    .subscribe((res) => {
      console.log('subscribed');
      const blob = new Blob([res], {type: 'application/csv'});
      const downloadURL = window.URL.createObjectURL(resizeBy);
      const link = document.createElement('a');
      link.href = downloadURL;
      link.download = 'export.pdf';
      link.click();
    });
  }

  ngOnDestroy() {
    if (this.statsSub) {
      this.statsSub.unsubscribe();
    }
    if (this.fileSub) {
    this.fileSub.unsubscribe();
    }
  }
}
