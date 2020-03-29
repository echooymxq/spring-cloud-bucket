package main

import (
	"encoding/json"
	"fmt"
	"io/ioutil"
	"net/http"
)

func main() {
	http.HandleFunc("/", helloWorld)
	http.HandleFunc("/health", health)
	http.HandleFunc("/echo", echo)

	go func() {
		//_ = gocron.Every(1).Second().Do(call)
		//<-gocron.Start()
	}()

	http.ListenAndServe("127.0.0.1:8081", nil)

}

func helloWorld(response http.ResponseWriter, request *http.Request) {
	_, _ = response.Write([]byte("Hello World!"))
}

func health(response http.ResponseWriter, request *http.Request) {
	println(request.RemoteAddr)
	health := Health{Status: "UP"}
	data, _ := json.Marshal(health)
	response.Header().Set("Content-Type", "application/json")
	_, _ = response.Write(data)
}

func echo(response http.ResponseWriter, request *http.Request) {

	user := request.URL.Query()["user"][0]
	_, _ = response.Write([]byte("echo " + user))

}

func call() {

	client := &http.Client{}

	url := "http://localhost:9028/sc-svc/test"

	req, _ := http.NewRequest("GET", url, nil)

	resp, _ := client.Do(req)

	defer resp.Body.Close()

	result, _ := ioutil.ReadAll(resp.Body)

	fmt.Println(string(result))

}

type Health struct {
	Status string `json:"status"`
}
