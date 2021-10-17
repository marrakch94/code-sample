import {Component, OnInit} from '@angular/core';
import {UsersService} from "../../service/users.service";
import {LocationStrategy, PlatformLocation, Location} from '@angular/common';
import {LegendItem, ChartType} from '../../lbd/lbd-chart/lbd-chart.component';
import * as Chartist from 'chartist';
declare interface TableData {
    headerRow: string[];
    dataRows: string[][];
}

@Component({
    selector: 'app-list-users',
    templateUrl: './list-users.component.html',
    styleUrls: ['./list-users.component.css']
})
export class ListUsersComponent implements OnInit {
    public tableData1: TableData;
    public activeUsersType: ChartType;
    public activeUsersData: any;
    public eactiveUsersLegendItems: LegendItem[];

    public InscriptionChartType: ChartType;
    public InscriptionChartData: any;
    public InscriptionChartOptions: any;
    public InscriptionChartResponsive: any[];
    public InscriptionChartLegendItems: LegendItem[];
    active =false;
    active1 =false;
    private userEnabled = 100;
    private userNotEnabled = 0;

    constructor(private userService: UsersService) {
        this.userService.userStatEnabled().subscribe(res => {
            const total = res[0] + res[1];
            this.userEnabled = (res[0]/total)*100;
            // @ts-ignore
            this.userNotEnabled = 100 - this.userEnabled.toFixed(0);
            console.log(this.userEnabled,this.userNotEnabled);
            this.activeUsersType = ChartType.Pie;
            this.activeUsersData = {
                labels: [this.userEnabled.toFixed(0) + '%', this.userNotEnabled + '%'],
                series: [this.userEnabled.toFixed(0), this.userNotEnabled]
            };
            this.eactiveUsersLegendItems = [
                {title: 'Active', imageClass: 'fa fa-circle text-info'},
                {title: 'Inactive', imageClass: 'fa fa-circle text-danger'},
            ];
            this.active = true;
        });
        this.userService.userStatDate().subscribe(res => {
            console.log(res);
            this.InscriptionChartType = ChartType.Line;
            this.InscriptionChartData = {
                labels: ['Jan', 'Feb', 'Mar', 'Apr', 'Mai', 'Jun', 'Jul', 'Aug', 'Sep', 'Oct', 'Nov', 'Dec'],
                series: [
                    [res[0], res[1], res[2], res[3], res[4], res[5], res[6], res[7], res[8], res[9], res[10], res[11]],
                ]
            };
            this.InscriptionChartOptions = {
                low: 0,
                high: 20,
                showArea: true,
                height: '245px',
                axisX: {
                    showGrid: false,
                },
                lineSmooth: Chartist.Interpolation.simple({
                    divisor: 3
                }),
                showLine: false,
                showPoint: false,
            };
            this.InscriptionChartResponsive = [
                ['screen and (max-width: 640px)', {
                    axisX: {
                        labelInterpolationFnc: function (value) {
                            return value[0];
                        }
                    }
                }]
            ];
            this.InscriptionChartLegendItems = [
                {title: 'New Users', imageClass: 'fa fa-circle text-info'},
            ];
            this.active1 = true;
        })
    }

    ngOnInit(): void {
        this.tableData1 = {
            headerRow: ['ID', 'User Name', 'Name', 'Surname', 'Email', 'Country', 'City', 'Salary', 'enabled', 'delete'],
            dataRows: []
        };
        this.userService.getAllUsers().subscribe(res => {
            console.log(res[0]);
            res.forEach(res =>
                this.tableData1.dataRows.push(
                    [res.id.toString(), res.userName, res.name, res.surname, res.email, res.country,
                        res.city, res.salary, res.enabled.toString(), 'Delete']
                ));
        });
    }

    delete(id: string) {
        if (window.confirm('Are sure you want to delete this item ?')) {
            const x = this.tableData1.dataRows.find(s => s[0] === id);
            this.tableData1.dataRows.forEach((element, index) => {
                if (element[0] === id) {
                    delete this.tableData1.dataRows[index];
                }
            });
            console.log(this.tableData1, x);
            this.userService.deleteUser(id).subscribe(res => {
                    window.alert('this user have benn deleted');
                }
            )
        }
    }

}
