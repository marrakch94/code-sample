import {AfterViewInit, Component, Input, OnInit} from '@angular/core';
import {LegendItem, ChartType} from '../../lbd/lbd-chart/lbd-chart.component';
import * as Chartist from 'chartist';
import {WordView} from '../../model/WordView';
import {WordService} from '../../service/word.service';
import {Stat} from '../../model/Stat';
import {MessageService} from '../../service/message.service';
import {MessageView} from '../../model/MessageView';
import {BiService} from '../../service/bi.service';


@Component({
    selector: 'app-forum-bi',
    templateUrl: './forum-bi.component.html',
    styleUrls: ['./forum-bi.component.css']
})
export class ForumBiComponent implements OnInit, AfterViewInit {
    public activityChartType: ChartType;
    public activityChartData: any;
    public activityChartOptions: any;
    public activityChartResponsive: any[];
    public activityChartLegendItems: LegendItem[];

    public hoursChartType: ChartType;
    public hoursChartData: any;
    public hoursChartOptions: any;
    public hoursChartResponsive: any[];
    public hoursChartLegendItems: LegendItem[];
    loadComponentMsg= false;

    public biRefresh: any;
    listWord: WordView[];
    listWordTxt: String[];
    listFrequency: number[];
    list0: number[];
    loadComponent = false;
    msgStat: Stat = new Stat('msgstat', 0, 0);
    listMsgView: MessageView[];
    listMonths: string[];
    listNbrMsg: number[];
    listNbrForum: number[];
    listNbrlike: number[];
    list0Msg: number[];
    userStat: Stat = new Stat('userstat',0,0);

    constructor(private wordService: WordService, private messageService: MessageService,
                private biService: BiService) {
    }

    ngOnInit(): void {
        this.messageService.getStat().subscribe(data => this.msgStat = data);
        this.biService.getStat().subscribe(data=>this.userStat=data);
        this.wordService.getN(10).subscribe({
            next: data => {
                this.listWord = data;
                this.listFrequency = data.map(x => x.frequency);
                this.listWordTxt = data.map(x => x.word_txt);
                this.list0 = data.map(x => 0);
            }, complete: () => {
                this.activityChartType = ChartType.Bar;
                this.activityChartData = {
                    labels: this.listWordTxt,
                    series: [this.listFrequency, this.list0]
                };
              /*  this.activityChartData = {
                    labels: ['hello', 'xx'],
                    series: [[2, 3], [3, 1]]
                };*/
                this.activityChartOptions = {
                    seriesBarDistance: 5,
                    axisX: {
                        showGrid: false
                    },
                    height: '245px'
                };
                this.activityChartResponsive = [
                    ['screen and (max-width: 640px)', {
                        seriesBarDistance: 5,
                        axisX: {
                            labelInterpolationFnc: function (value) {
                                return value[0];
                            }
                        }
                    }]
                ];
                this.activityChartLegendItems = [
                    {title: 'Words', imageClass: 'fa fa-circle text-info'},
                    {title: '', imageClass: ''}
                ];
                this.loadComponent = true;
            }
        });
        this.biService.getByYear(2021).subscribe({
            next: data => {
               // this.listMsgView = data;
                this.listMonths = data.map(x => x.tempsStringMonth.substring(0,3));
                this.listNbrMsg = data.map(x => x.messageNbr);
                this.listNbrlike = data.map(x => x.likeNbr);
                this.listNbrForum =data.map(x => x.forumNbr)
            }, complete: () => {
                this.hoursChartType = ChartType.Line;

                this.hoursChartData = {
                    labels: this.listMonths,
                    series: [this.listNbrMsg, this.listNbrlike, this.listNbrForum]
                };
                console.log(this.listMonths);
                console.log(this.listNbrMsg);

                this.hoursChartOptions = {
                    low: 0,
                    high: 150,
                    showArea: false,
                    height: '245px',
                    axisX: {
                        showGrid: false,
                    },
                    lineSmooth: Chartist.Interpolation.simple({
                        divisor: 3
                    }),
                    showLine: true,
                    showPoint: false,
                };
                this.hoursChartResponsive = [
                    ['screen and (max-width: 640px)', {
                        axisX: {
                            labelInterpolationFnc: function (value) {
                                return value[0];
                            }
                        }
                    }]
                ];
                this.hoursChartLegendItems = [
                    { title: 'Posts', imageClass: 'fa fa-circle text-info' },
                    { title: 'Likes', imageClass: 'fa fa-circle text-danger' },
                    { title: 'Forums', imageClass: 'fa fa-circle text-warning' }
                ];
                this.loadComponentMsg = true;
            }
        });
        // });
    }

    ngAfterViewInit(): void {

    }

    refreshData() {
        this.activityChartData = {
            labels: this.listWordTxt,
            series: [this.listFrequency, this.listFrequency]
        };

    }

    refreshLists() {
        this.biRefresh = 'hello'
    }

    loadMyChildComponent() {
        this.loadComponent = true;
    }

}
