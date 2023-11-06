package com.nhnacademy.yunhwa._8_thread_pool.exam02;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Exam02 {
    public static void main(String[] args) {

        // 내려 받을 파일의 링크 목록을 준비한다
        String[] urls = { "https://nhnacademy.dooray.com/share/drive-files/ocfkrcbb5vui.JMwL9-kHTKKJ6YhS-Xykpg",
                "https://nhnacademy.dooray.com/share/drive-files/ocfkrcbb5vui.CH51Oh3xTaSSmHwhVhYrgQ",
                "https://nhnacademy.dooray.com/share/drive-files/ocfkrcbb5vui.6xuIQS1YSESJmigo2ECzQw",
                "https://nhnacademy.dooray.com/share/drive-files/ocfkrcbb5vui.xzEwVuqrTVm23HKK_vCm0Q",
                "https://nhnacademy.dooray.com/share/drive-files/ocfkrcbb5vui.X_otcNhCRKWruinRW2gyFA",
                "https://nhnacademy.dooray.com/share/drive-files/ocfkrcbb5vui.WXsaSz-ARo2DryGsEK0S_w"};


        // thread pool 을 생성하고, DownloadWorker object 를 생성해 등록한다
        ExecutorService executor = Executors.newFixedThreadPool(3);

        for (String url : urls) {
            Runnable worker = new DownloadWorker(url);
            executor.execute(worker);
        }

        executor.shutdown();
        while (!executor.isTerminated()) {
        }

        System.out.println("작업이 완료되었습니다.");
    }
}
