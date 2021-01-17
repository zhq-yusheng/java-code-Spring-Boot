function redPackage() {
    const $redPackage = $('.js-RedPackage');

    const $redPackageBox = $('.js-RedPackageBox');
    const redPackageWidth = $redPackage.width();
    const redPackageBoxWidth = $redPackageBox.width();
//因为红包有角度旋转的问题，所以需要计算一下，避免旋转之后溢出屏幕
    const basePadding = 30;
    const maxLeftPx = redPackageWidth - redPackageBoxWidth - basePadding * 2;

//每一个红包都是相对于父元素定位，通过z-index来设置层级
    let zIndex = 1;

    function bindEvent() {
        $redPackage.on('click', '.js-RedPackageBox', function () {
            //拿到每个红包的数据
            const data = $(this).data('txt');
        }
    }

//生成mix-max的随机数
    function getRandom(min, max) {
        return Math.round(Math.random() * (max - min) + min);
    }

//红包的移动
    function redPackageBoxSpeed($el, time) {
        $el.animate(
            {
                top: '130%',
            },
            time * 1000,
            function () {
                $el.remove();
            }
        );
    }

//生成红包
    function createRedPackageNode() {
        const $newNode = $redPackageBox.clone(true);
        //红包携带的数据
        const txt = keyList.shift();
        keyList.push(txt);
        $newNode.attr('data-txt', JSON.stringify(txt));

        //红包随机旋转-30～30度
        $newNode.css({
            'z-index': zIndex++,
            left: getRandom(basePadding, maxLeftPx) + 'px',
            transform: 'rotate(' + getRandom(-30, 30) + 'deg)',
        });
        $redPackage.append($newNode);

        redPackageBoxSpeed($newNode, 4);
    }

//红包的动态创建
    function createRedPackageRain() {
        setInterval(() = > {
            createRedPackageNode();
    },
        300
    )
        ;
    }

    function ready() {
        bindEvent();
        createRedPackageRain();
    }

    ready();
}