import { Routes } from '@angular/router';

import { DashboardComponent } from '../../pages/dashboard/dashboard.component';
import { UserComponent } from '../../pages/user/user.component';
import { TableComponent } from '../../pages/table/table.component';
import { TypographyComponent } from '../../pages/typography/typography.component';
import { IconsComponent } from '../../pages/icons/icons.component';
import { MapsComponent } from '../../pages/maps/maps.component';
import { NotificationsComponent } from '../../pages/notifications/notifications.component';
import { UpgradeComponent } from '../../pages/upgrade/upgrade.component';
import { LoginComponent } from '../../pages/login/login.component';
import { BookComponent } from 'app/pages/book/book.component';
import { AddBookComponent } from 'app/pages/book/add-book/add-book.component';
import { EditBookComponent } from 'app/pages/book/edit-book/edit-book.component';
import { UpdateUserComponent } from 'app/pages/user/update-user/update-user.component';


export const AdminLayoutRoutes: Routes = [
    { path: 'dashboard', component: DashboardComponent },
    { path: 'user', component: UserComponent },
    { path: 'table', component: TableComponent },
    { path: 'typography', component: TypographyComponent },
    { path: 'icons', component: IconsComponent },
    { path: 'maps', component: MapsComponent },
    { path: 'login', component: LoginComponent },
    { path: 'notifications', component: NotificationsComponent },
    { path: 'upgrade', component: UpgradeComponent },
    { path: 'book', component: BookComponent },
    { path: 'add-book', component: AddBookComponent },
    { path: 'edit-book/:id', component: EditBookComponent },
    { path: 'update-user/:id', component: UpdateUserComponent } 
];
