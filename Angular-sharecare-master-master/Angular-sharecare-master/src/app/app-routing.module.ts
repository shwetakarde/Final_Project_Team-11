import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import{HeaderComponent} from './header/header.component';
import { RegistrationComponent } from './registration/registration.component';
import { LoginComponent } from './login/login.component';
import { IndexpageComponent } from './indexpage/indexpage.component';
import{FooterComponent} from './footer/footer.component'

const routes: Routes = [
  { path: '', component: IndexpageComponent },
  { path: 'header', component: HeaderComponent },
  {path:'footer',component:FooterComponent},
  { path: 'registration', component: RegistrationComponent },
  { path: 'login', component: LoginComponent }

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
