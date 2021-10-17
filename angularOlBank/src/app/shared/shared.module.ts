import {NgModule} from '@angular/core';
import {CommonModule} from '@angular/common';
import {FormsModule} from "@angular/forms";
import {HttpClientModule} from "@angular/common/http";
import {Context} from "./services/context.service";
import {LoadingService} from "./services/LoadingService.service";


@NgModule({
    declarations: [
        // GalleryPhotoComponent,
        // CameraComponent,
        // ImageViewerComponent,
        // ImageProcessingComponent,
        // CustomSpinnerComponent,
        //  ZoomDirective
    ],
    imports: [
        FormsModule,
        HttpClientModule,
        CommonModule,
        // VirtualScrollerModule,
        // ListViewAllModule, ImageCropperModule,
        // PinchZoomModule,
    ],
    exports: [
        //  GalleryPhotoComponent,
        //  CameraComponent,
        // ImageViewerComponent,
        // ImageProcessingComponent,
        //CustomSpinnerComponent,
    ],
    providers: [Context
        //, UserService
        , LoadingService
    ]
})
export class SharedModule {
}
