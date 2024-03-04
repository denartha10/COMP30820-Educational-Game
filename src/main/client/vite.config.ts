import {defineConfig} from "vite";

export default defineConfig({
    build: {
        outDir: '../resources/static/',
        emptyOutDir: true,
    },
});

//https://www.jessym.com/articles/bundling-react-vite-with-spring-boot
