import {Component, Input, OnInit, AfterViewInit, ChangeDetectionStrategy, OnChanges, SimpleChanges} from '@angular/core';
import * as Chartist from 'chartist';
import {ForumBiComponent} from '../../forums/forum-bi/forum-bi.component';

export interface LegendItem {
    title: string;
    imageClass: string;
}

export enum ChartType {
    Pie,
    Line,
    Bar
}

@Component({
    selector: 'lbd-chart',
    templateUrl: './lbd-chart.component.html',
    changeDetection: ChangeDetectionStrategy.Default
})
export class LbdChartComponent implements OnInit, AfterViewInit /*OnChanges*/ {
    static currentId = 1;

    @Input()
    public title: string;

    @Input()
    public subtitle: string;

    @Input()
    public chartClass: string;

    @Input()
    public chartType: ChartType;

    @Input()
    public chartData: any;

    @Input()
    public chartOptions: any;

    @Input()
    public chartResponsive: any[];

    @Input()
    public footerIconClass: string;

    @Input()
    public footerText: string;

    @Input()
    public legendItems: LegendItem[];

    @Input()
    public withHr: boolean;

    public chartId: string;

    constructor() {
    }

    public ngOnInit(): void {
        this.chartId = `lbd-chart-${LbdChartComponent.currentId++}`;
    }

    public ngAfterViewInit(): void {
        switch (this.chartType) {
            case ChartType.Pie:
                new Chartist.Pie(`#${this.chartId}`, this.chartData, this.chartOptions, this.chartResponsive);
                break;
            case ChartType.Line:
                new Chartist.Line(`#${this.chartId}`, this.chartData, this.chartOptions, this.chartResponsive);
                break;
            case ChartType.Bar:
                new Chartist.Bar(`#${this.chartId}`, this.chartData, this.chartOptions, this.chartResponsive);
                break;
        }
    }
/*
    ngOnChanges(changes: SimpleChanges): void {
            console.log('changes !!')
        console.log(this.chartData)
        if(this.chartData.labels!==undefined) {
           // setTimeout(() => {
            //   this.ngAfterViewInit();
           // }, 5000);
            }
    }*/
}
