let api = [];
const apiDocListSize = 1
api.push({
    name: 'default',
    order: '1',
    list: []
})
api[0].list.push({
    alias: 'AnnouncementController',
    order: '1',
    link: '',
    desc: '',
    list: []
})
api[0].list[0].list.push({
    order: '1',
    deprecated: 'false',
    url: '/announcements/',
    desc: '',
});
api[0].list[0].list.push({
    order: '2',
    deprecated: 'false',
    url: '/announcements/{id}',
    desc: '',
});
api[0].list[0].list.push({
    order: '3',
    deprecated: 'false',
    url: '/announcements/',
    desc: '',
});
api[0].list[0].list.push({
    order: '4',
    deprecated: 'false',
    url: '/announcements/delete/{id}',
    desc: '',
});
api[0].list[0].list.push({
    order: '5',
    deprecated: 'false',
    url: '/announcements/update',
    desc: '',
});
api[0].list.push({
    alias: 'CategoryController',
    order: '2',
    link: '',
    desc: '',
    list: []
})
api[0].list[1].list.push({
    order: '1',
    deprecated: 'false',
    url: '/categories/',
    desc: '',
});
api[0].list[1].list.push({
    order: '2',
    deprecated: 'false',
    url: '/categories/{id}',
    desc: '',
});
api[0].list[1].list.push({
    order: '3',
    deprecated: 'false',
    url: '/categories/delete/{id}',
    desc: '',
});
api[0].list[1].list.push({
    order: '4',
    deprecated: 'false',
    url: '/categories/',
    desc: '',
});
api[0].list[1].list.push({
    order: '5',
    deprecated: 'false',
    url: '/categories/update',
    desc: '',
});
api[0].list[1].list.push({
    order: '6',
    deprecated: 'false',
    url: '/categories/alldishes',
    desc: '',
});
api[0].list.push({
    alias: 'ChefController',
    order: '3',
    link: '',
    desc: '',
    list: []
})
api[0].list[2].list.push({
    order: '1',
    deprecated: 'false',
    url: '/chef/',
    desc: '',
});
api[0].list[2].list.push({
    order: '2',
    deprecated: 'false',
    url: '/chef/{id}',
    desc: '',
});
api[0].list[2].list.push({
    order: '3',
    deprecated: 'false',
    url: '/chef/',
    desc: '',
});
api[0].list[2].list.push({
    order: '4',
    deprecated: 'false',
    url: '/chef/update',
    desc: '',
});
api[0].list[2].list.push({
    order: '5',
    deprecated: 'false',
    url: '/chef/delete/{id}',
    desc: '',
});
api[0].list.push({
    alias: 'CustomerController',
    order: '4',
    link: '',
    desc: '',
    list: []
})
api[0].list[3].list.push({
    order: '1',
    deprecated: 'false',
    url: '/customer/',
    desc: '',
});
api[0].list[3].list.push({
    order: '2',
    deprecated: 'false',
    url: '/customer/{id}',
    desc: '',
});
api[0].list[3].list.push({
    order: '3',
    deprecated: 'false',
    url: '/customer/',
    desc: '',
});
api[0].list[3].list.push({
    order: '4',
    deprecated: 'false',
    url: '/customer/update',
    desc: '',
});
api[0].list[3].list.push({
    order: '5',
    deprecated: 'false',
    url: '/customer/delete/{id}',
    desc: '',
});
api[0].list[3].list.push({
    order: '6',
    deprecated: 'false',
    url: '/customer/{pageNum}/{pageSize}',
    desc: '',
});
api[0].list.push({
    alias: 'DishController',
    order: '5',
    link: '',
    desc: '',
    list: []
})
api[0].list[4].list.push({
    order: '1',
    deprecated: 'false',
    url: '/dishes/',
    desc: '',
});
api[0].list[4].list.push({
    order: '2',
    deprecated: 'false',
    url: '/dishes/{id}',
    desc: '',
});
api[0].list[4].list.push({
    order: '3',
    deprecated: 'false',
    url: '/dishes/',
    desc: '',
});
api[0].list[4].list.push({
    order: '4',
    deprecated: 'false',
    url: '/dishes/update',
    desc: '',
});
api[0].list[4].list.push({
    order: '5',
    deprecated: 'false',
    url: '/dishes/delete/{id}',
    desc: '',
});
api[0].list[4].list.push({
    order: '6',
    deprecated: 'false',
    url: '/dishes/bycategory/{categoryID}',
    desc: '',
});
api[0].list[4].list.push({
    order: '7',
    deprecated: 'false',
    url: '/dishes/byname/{name}',
    desc: '',
});
api[0].list.push({
    alias: 'LoginController',
    order: '6',
    link: '',
    desc: '',
    list: []
})
api[0].list[5].list.push({
    order: '1',
    deprecated: 'false',
    url: '/login/manager',
    desc: '',
});
api[0].list[5].list.push({
    order: '2',
    deprecated: 'false',
    url: '/login/customer',
    desc: '',
});
api[0].list[5].list.push({
    order: '3',
    deprecated: 'false',
    url: '/login/chef',
    desc: '',
});
api[0].list.push({
    alias: 'LogoutController',
    order: '7',
    link: '',
    desc: '',
    list: []
})
api[0].list[6].list.push({
    order: '1',
    deprecated: 'false',
    url: '/logout/manager',
    desc: '',
});
api[0].list[6].list.push({
    order: '2',
    deprecated: 'false',
    url: '/logout/customer',
    desc: '',
});
api[0].list[6].list.push({
    order: '3',
    deprecated: 'false',
    url: '/logout/chef',
    desc: '',
});
api[0].list.push({
    alias: 'ManagerController',
    order: '8',
    link: '',
    desc: '',
    list: []
})
api[0].list[7].list.push({
    order: '1',
    deprecated: 'false',
    url: '/managers/',
    desc: '',
});
api[0].list[7].list.push({
    order: '2',
    deprecated: 'false',
    url: '/managers/{id}',
    desc: '',
});
api[0].list[7].list.push({
    order: '3',
    deprecated: 'false',
    url: '/managers/',
    desc: '',
});
api[0].list[7].list.push({
    order: '4',
    deprecated: 'false',
    url: '/managers/update',
    desc: '',
});
api[0].list[7].list.push({
    order: '5',
    deprecated: 'false',
    url: '/managers/delete/{id}',
    desc: '',
});
api[0].list.push({
    alias: 'OrderDetailController',
    order: '9',
    link: '',
    desc: '',
    list: []
})
api[0].list[8].list.push({
    order: '1',
    deprecated: 'false',
    url: '/orderdetail/',
    desc: '',
});
api[0].list[8].list.push({
    order: '2',
    deprecated: 'false',
    url: '/orderdetail/{id}',
    desc: '',
});
api[0].list[8].list.push({
    order: '3',
    deprecated: 'false',
    url: '/orderdetail/',
    desc: '',
});
api[0].list[8].list.push({
    order: '4',
    deprecated: 'false',
    url: '/orderdetail/update',
    desc: '',
});
api[0].list[8].list.push({
    order: '5',
    deprecated: 'false',
    url: '/orderdetail/delete/{id}',
    desc: '',
});
api[0].list[8].list.push({
    order: '6',
    deprecated: 'false',
    url: '/orderdetail/byorder/{orderID}',
    desc: '',
});
api[0].list.push({
    alias: 'OrderInfoController',
    order: '10',
    link: '',
    desc: '',
    list: []
})
api[0].list[9].list.push({
    order: '1',
    deprecated: 'false',
    url: '/orderinfo/',
    desc: '',
});
api[0].list[9].list.push({
    order: '2',
    deprecated: 'false',
    url: '/orderinfo/{id}',
    desc: '',
});
api[0].list[9].list.push({
    order: '3',
    deprecated: 'false',
    url: '/orderinfo/{status}/{limit}',
    desc: '',
});
api[0].list[9].list.push({
    order: '4',
    deprecated: 'false',
    url: '/orderinfo/',
    desc: '',
});
api[0].list[9].list.push({
    order: '5',
    deprecated: 'false',
    url: '/orderinfo/submit',
    desc: '',
});
api[0].list[9].list.push({
    order: '6',
    deprecated: 'false',
    url: '/orderinfo/update',
    desc: '',
});
api[0].list[9].list.push({
    order: '7',
    deprecated: 'false',
    url: '/orderinfo/updatestatus',
    desc: '',
});
api[0].list[9].list.push({
    order: '8',
    deprecated: 'false',
    url: '/orderinfo/delete/{id}',
    desc: '',
});
api[0].list[9].list.push({
    order: '9',
    deprecated: 'false',
    url: '/orderinfo/pages',
    desc: '',
});
api[0].list[9].list.push({
    order: '10',
    deprecated: 'false',
    url: '/orderinfo/bycustomerID/{id}',
    desc: '',
});
api[0].list[9].list.push({
    order: '11',
    deprecated: 'false',
    url: '/orderinfo/orderhistory/{id}',
    desc: '',
});
api[0].list.push({
    alias: 'RegisterController',
    order: '11',
    link: '',
    desc: '',
    list: []
})
api[0].list[10].list.push({
    order: '1',
    deprecated: 'false',
    url: '/register/check',
    desc: '',
});
api[0].list[10].list.push({
    order: '2',
    deprecated: 'false',
    url: '/register/',
    desc: '',
});
api[0].list[10].list.push({
    order: '3',
    deprecated: 'false',
    url: '/register/getcode',
    desc: '',
});
api[0].list.push({
    alias: 'UpdatePwdController',
    order: '12',
    link: '',
    desc: '',
    list: []
})
api[0].list[11].list.push({
    order: '1',
    deprecated: 'false',
    url: '/updatepwd/customer',
    desc: '',
});
api[0].list[11].list.push({
    order: '2',
    deprecated: 'false',
    url: '/updatepwd/chef',
    desc: '',
});
api[0].list[11].list.push({
    order: '3',
    deprecated: 'false',
    url: '/updatepwd/manager',
    desc: '',
});
document.onkeydown = keyDownSearch;
function keyDownSearch(e) {
    const theEvent = e;
    const code = theEvent.keyCode || theEvent.which || theEvent.charCode;
    if (code === 13) {
        const search = document.getElementById('search');
        const searchValue = search.value.toLocaleLowerCase();

        let searchGroup = [];
        for (let i = 0; i < api.length; i++) {

            let apiGroup = api[i];

            let searchArr = [];
            for (let i = 0; i < apiGroup.list.length; i++) {
                let apiData = apiGroup.list[i];
                const desc = apiData.desc;
                if (desc.toLocaleLowerCase().indexOf(searchValue) > -1) {
                    searchArr.push({
                        order: apiData.order,
                        desc: apiData.desc,
                        link: apiData.link,
                        list: apiData.list
                    });
                } else {
                    let methodList = apiData.list || [];
                    let methodListTemp = [];
                    for (let j = 0; j < methodList.length; j++) {
                        const methodData = methodList[j];
                        const methodDesc = methodData.desc;
                        if (methodDesc.toLocaleLowerCase().indexOf(searchValue) > -1) {
                            methodListTemp.push(methodData);
                            break;
                        }
                    }
                    if (methodListTemp.length > 0) {
                        const data = {
                            order: apiData.order,
                            desc: apiData.desc,
                            link: apiData.link,
                            list: methodListTemp
                        };
                        searchArr.push(data);
                    }
                }
            }
            if (apiGroup.name.toLocaleLowerCase().indexOf(searchValue) > -1) {
                searchGroup.push({
                    name: apiGroup.name,
                    order: apiGroup.order,
                    list: searchArr
                });
                continue;
            }
            if (searchArr.length === 0) {
                continue;
            }
            searchGroup.push({
                name: apiGroup.name,
                order: apiGroup.order,
                list: searchArr
            });
        }
        let html;
        if (searchValue === '') {
            const liClass = "";
            const display = "display: none";
            html = buildAccordion(api,liClass,display);
            document.getElementById('accordion').innerHTML = html;
        } else {
            const liClass = "open";
            const display = "display: block";
            html = buildAccordion(searchGroup,liClass,display);
            document.getElementById('accordion').innerHTML = html;
        }
        const Accordion = function (el, multiple) {
            this.el = el || {};
            this.multiple = multiple || false;
            const links = this.el.find('.dd');
            links.on('click', {el: this.el, multiple: this.multiple}, this.dropdown);
        };
        Accordion.prototype.dropdown = function (e) {
            const $el = e.data.el;
            let $this = $(this), $next = $this.next();
            $next.slideToggle();
            $this.parent().toggleClass('open');
            if (!e.data.multiple) {
                $el.find('.submenu').not($next).slideUp("20").parent().removeClass('open');
            }
        };
        new Accordion($('#accordion'), false);
    }
}

function buildAccordion(apiGroups, liClass, display) {
    let html = "";
    if (apiGroups.length > 0) {
        if (apiDocListSize === 1) {
            let apiData = apiGroups[0].list;
            let order = apiGroups[0].order;
            for (let j = 0; j < apiData.length; j++) {
                html += '<li class="'+liClass+'">';
                html += '<a class="dd" href="#_'+order+'_'+apiData[j].order+'_' + apiData[j].link + '">' + apiData[j].order + '.&nbsp;' + apiData[j].desc + '</a>';
                html += '<ul class="sectlevel2" style="'+display+'">';
                let doc = apiData[j].list;
                for (let m = 0; m < doc.length; m++) {
                    let spanString;
                    if (doc[m].deprecated === 'true') {
                        spanString='<span class="line-through">';
                    } else {
                        spanString='<span>';
                    }
                    html += '<li><a href="#_'+order+'_' + apiData[j].order + '_' + doc[m].order + '_' + doc[m].desc + '">' + apiData[j].order + '.' + doc[m].order + '.&nbsp;' + spanString + doc[m].desc + '<span></a> </li>';
                }
                html += '</ul>';
                html += '</li>';
            }
        } else {
            for (let i = 0; i < apiGroups.length; i++) {
                let apiGroup = apiGroups[i];
                html += '<li class="'+liClass+'">';
                html += '<a class="dd" href="#_'+apiGroup.order+'_' + apiGroup.name + '">' + apiGroup.order + '.&nbsp;' + apiGroup.name + '</a>';
                html += '<ul class="sectlevel1">';

                let apiData = apiGroup.list;
                for (let j = 0; j < apiData.length; j++) {
                    html += '<li class="'+liClass+'">';
                    html += '<a class="dd" href="#_'+apiGroup.order+'_'+ apiData[j].order + '_'+ apiData[j].link + '">' +apiGroup.order+'.'+ apiData[j].order + '.&nbsp;' + apiData[j].desc + '</a>';
                    html += '<ul class="sectlevel2" style="'+display+'">';
                    let doc = apiData[j].list;
                    for (let m = 0; m < doc.length; m++) {
                       let spanString;
                       if (doc[m].deprecated === 'true') {
                           spanString='<span class="line-through">';
                       } else {
                           spanString='<span>';
                       }
                       html += '<li><a href="#_'+apiGroup.order+'_' + apiData[j].order + '_' + doc[m].order + '_' + doc[m].desc + '">'+apiGroup.order+'.' + apiData[j].order + '.' + doc[m].order + '.&nbsp;' + spanString + doc[m].desc + '<span></a> </li>';
                   }
                    html += '</ul>';
                    html += '</li>';
                }

                html += '</ul>';
                html += '</li>';
            }
        }
    }
    return html;
}