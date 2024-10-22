import { Component, Input } from '@angular/core';
import { CommonModule } from '@angular/common';
import { HousingLocation } from '../housinglocation';
import { RouterLink, RouterOutlet } from '@angular/router';
@Component({
  selector: 'app-housing-location',
  standalone: true,
  imports: [RouterLink,RouterOutlet],
  template: `
  <section class="listing">
    <p>{{ housingLocation.titel }}</p>
      <p class="info">Geschreven door: {{ housingLocation.auteur }}</p>
      <img src="{{ housingLocation.afbeeldingURL }}" />
      <p class="info">Dit boek bevat {{ housingLocation.aantalExemplaren }} exemplaren.</p>
  </section>
`,
  styleUrl: './housing-location.component.css'
})
export class HousingLocationComponent {
  @Input() housingLocation!: HousingLocation;
}
