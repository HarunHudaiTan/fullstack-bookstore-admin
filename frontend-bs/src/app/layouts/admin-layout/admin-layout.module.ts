import { NgModule } from '@angular/core';
import { RouterModule } from '@angular/router';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';

import { AdminLayoutRoutes } from './admin-layout.routing';

import { DashboardComponent }       from '../../pages/dashboard/dashboard.component';
import { UserComponent }            from '../../pages/user/user.component';
import { TableComponent }           from '../../pages/table/table.component';
import { TypographyComponent }      from '../../pages/typography/typography.component';
import { IconsComponent }           from '../../pages/icons/icons.component';
import { MapsComponent }            from '../../pages/maps/maps.component';
import { NotificationsComponent }   from '../../pages/notifications/notifications.component';
import { UpgradeComponent }         from '../../pages/upgrade/upgrade.component';
import { BookComponent }            from '../../pages/book/book.component';
import { AddBookComponent }         from '../../pages/book/add-book/add-book.component';
import { AuthorComponent }          from '../../pages/author/author.component';

import { NgbModule } from '@ng-bootstrap/ng-bootstrap';
import { GenreComponent } from 'app/pages/genre/genre.component';

@NgModule({
  imports: [
    CommonModule,
    RouterModule.forChild(AdminLayoutRoutes),
    FormsModule,
    NgbModule,
    AuthorComponent,
    BookComponent,
    AddBookComponent,
    UserComponent,
    GenreComponent
  ],
  declarations: [
    DashboardComponent,
    TableComponent,
    UpgradeComponent,
    TypographyComponent,
    IconsComponent,
    MapsComponent,
    NotificationsComponent,
  
  ]
})

export class AdminLayoutModule {}
