class Tabs {
    constructor(id) {
        this.id = id;

        this.initialize();
    }

    initialize() {
        this.getTabs()
            .forEach((tab) => {
                tab.addEventListener('click', (event) => this.clickTab(event))
            })
    }

    getTabs() {
        return document.querySelectorAll('#' + this.id + ' > .tabs > ul > li > a');
    }

    clickTab(event) {
        const target = event.currentTarget;
        if (target.parentElement.classList.contains('is-active')) return;

        const id = target.id;
        this.getTabs().forEach((tab) => {
            if (tab.id === id) {
                tab.parentElement.classList.add('is-active');
            } else {
                tab.parentElement.classList.remove('is-active');
            }
        });

        const bodyId = id.replace(/-tab$/, '-body')
        this.getBodies().forEach((body) => {
            if (body.id === bodyId) {
                body.classList.add('is-active');
            } else {
                body.classList.remove('is-active');
            }
        })
    }

    getBodies() {
        return document.querySelectorAll('#' + this.id + ' > .tabs-bodies > .tabs-body');
    }
}