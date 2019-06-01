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

<<<<<<< HEAD
### 如何使用 vscode 调试

https://github.com/Microsoft/vscode-recipes/tree/master/Electron
=======
>>>>>>> c6c1544c9b8ac69bf07cb9c1c0d9590b78f00b65

1. 下载 vscode 插件 Node Debugger 和  the [Debugger for Chrome](https://github.com/Microsoft/vscode-chrome-debug) extension 

2. 在 `.vscode/launch.json` 中添加配置即可

```json
{
  "version": "0.2.0",
  "configurations": [
      {
          "type": "node",
          "request": "launch",
          "name": "Electron: Main",
          "protocol": "inspector",
          "runtimeExecutable": "${workspaceFolder}/node_modules/.bin/electron",
          "runtimeArgs": [
              "--remote-debugging-port=9223",
              "."
          ],
          "windows": {
              "runtimeExecutable": "${workspaceFolder}/node_modules/.bin/electron.cmd"
          }
      },
      {
          "name": "Electron: Renderer",
          "type": "chrome",
          "request": "attach",
          "port": 9223,
          "webRoot": "${workspaceFolder}",
          "timeout": 30000
      }
  ],
  "compounds": [
      {
          "name": "Electron: All",
          "configurations": [
              "Electron: Main",
              "Electron: Renderer"
          ]
      }
  ]
}
```

### 证书问题

https://www.electron.build/code-signing

###Requiring electron dialog from render process is undefined

<https://stackoverflow.com/questions/36637201/requiring-electron-dialog-from-render-process-is-undefined>

```javascript
const { app,clipboard,dialog} = require('electron').remote
```

