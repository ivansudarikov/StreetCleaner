var gulp = require('gulp');
var sourcemaps = require('gulp-sourcemaps');
var sass = require('gulp-sass');
var autoprefixer = require('gulp-autoprefixer');
var notify = require('gulp-notify');
var connect = require('gulp-connect');


gulp.task('default', function () {

});

gulp.task('connect', function() {
	connect.server({
		root: 'static',
		port: 8000,
		livereload: true
	});
});

gulp.task('html', function () {
	gulp.src('./static/*.html')
		.pipe(connect.reload());
});

gulp.task('main:css', function() {
	gulp.src('static/scss/main.scss')
		.pipe(sourcemaps.init())
		.pipe(sass({
			errLogToConsole: false
		}).on('error', function(err) {
			return notify().write(err);
		}))
		.pipe(autoprefixer({
			browsers: ['> 1%'],
			cascade: false
		}))
		.pipe(sourcemaps.write('.'))
		.pipe(gulp.dest('static/css/'))
		.pipe(connect.reload())
		.pipe(notify('CSS Compiled' ));
});

gulp.task('main:watch', function () {
	gulp.watch('static/scss/**', ['main:css']);
	gulp.watch(['static/*.html'], ['html']);
});
