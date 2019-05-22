# Electron

## api 示例

### electron-packager

```
./node_modules/.bin/electron .
./node_modules/.bin/electron-packager . --asar
./node_modules/.bin/electron-packager . --all
```

### helloworld

```shell
git clone https://github.com/electron/electron-quick-start
cd electron-quick-start
npm install
npm start
```

### 打开 dev tools

```js
const { BrowserWindow } = require('electron')

let win = new BrowserWindow()
win.webContents.openDevTools()
```

### 打包 windows exe

package.json 配置

```json
"scripts": {
	"start": "electron .",
	"package-win": "electron-packager . HelloWorld --platform=win32 --arch=x64  --out=./out --app-version=1.0.0"
}
```

打包

```shell
npm run-script package-win
```




